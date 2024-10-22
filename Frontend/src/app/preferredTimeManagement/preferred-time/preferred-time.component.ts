import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PreferredTimeDto} from "../../dto/preferred-time-dto";
import {PreferredTimeService} from "../../service/preferred-time.service";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-preferred-time',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './preferred-time.component.html',
  styleUrl: './preferred-time.component.css'
})
export class PreferredTimeComponent implements OnInit{

  preferredTimes: PreferredTimeDto[] = [];
  defaultPreferredTime: PreferredTimeDto | undefined;

  days = ["Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek"]

  preferredTimeForm = new FormGroup({
    id: new FormControl(''),
    day: new FormControl(''),
    hour: new FormControl(<number | null>null),
  })

  constructor(private preferredTimeService: PreferredTimeService) {}

  ngOnInit(): void {
    this.preferredTimeService.listPreferredTimes();

    this.preferredTimeService.preferredTimes$.subscribe(resultData => {
      this.preferredTimes = resultData;
    });
  }

  savePreferredTime(newPreferredTime: PreferredTimeDto): void {
    this.preferredTimeService.savePreferredTime(newPreferredTime)
    this.preferredTimeService.listPreferredTimes();
  }

  deletePreferredTime(id: number): void {
    this.preferredTimeService.deletePreferredTime(id).subscribe(() => {
      this.preferredTimeService.listPreferredTimes();
    });
  }

  updatePreferredTime(updatedPreferredTime: PreferredTimeDto): void {
    this.preferredTimeService.updatePreferredTime(updatedPreferredTime)
    this.preferredTimeService.listPreferredTimes();
  }

  handleSubmit(event: any) {
    const preferredTime = {
      id: this.preferredTimeForm.value.id ? Number(this.preferredTimeForm.value.id) : 0,
      day: this.preferredTimeForm.value.day!,
      hour: this.preferredTimeForm.value.hour!,
    };

    if(event.submitter.name == "save") {
      this.preferredTimeForm.get('id')?.setValue(null);
      preferredTime.id = 0;
      this.savePreferredTime(preferredTime);
    }
    else if(event.submitter.name == "update") {
      this.updatePreferredTime(preferredTime);
      this.preferredTimeForm.get('id')?.setValue(null);
    }
  }

  updatePreferredTimeForm(preferredTime: PreferredTimeDto) {
    this.defaultPreferredTime = preferredTime;

    this.preferredTimeForm.patchValue({
      id: this.defaultPreferredTime.id!.toString(),
      day: this.defaultPreferredTime.day,
      hour: this.defaultPreferredTime.hour,
    });
  }
}
