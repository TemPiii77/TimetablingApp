import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-class',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './class.component.html',
  styleUrl: './class.component.css'
})
export class ClassComponent implements OnInit{

  classes: ClassDto[] = [];
  defaultClass: ClassDto | undefined;

  fields = ["Általános", "Informatika", "Angol"];

  classForm = new FormGroup({
    id: new FormControl(''),
    year: new FormControl(<number | null>null),
    grade: new FormControl(<number | null>null),
    group: new FormControl(''),
    field: new FormControl(''),
  })

  constructor(private classService: ClassService) {}

  ngOnInit(): void {
    this.classService.listClasses();

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });
  }

  saveClass(newClass: ClassDto): void {
    this.classService.saveClass(newClass)
    this.classService.listClasses();
  }

  deleteClass(id: number): void {
    this.classService.deleteClass(id).subscribe(() => {
      this.classService.listClasses();
    });
  }

  updateClass(updatedClass: ClassDto): void {
    this.classService.updateClass(updatedClass)
    this.classService.listClasses();
  }

  handleSubmit(event: any) {
    const cclass = {
      id: this.classForm.value.id ? Number(this.classForm.value.id) : 0,
      year: this.classForm.value.year!,
      grade: this.classForm.value.grade!,
      group: this.classForm.value.group!,
      field: this.classForm.value.field!
    };

    if(event.submitter.name == "save") {
      this.classForm.get('id')?.setValue(null);
      cclass.id = 0;
      this.saveClass(cclass);
    }
    else if(event.submitter.name == "update") {
      this.updateClass(cclass);
      this.classForm.get('id')?.setValue(null);
    }
  }

  updateClassForm(classroom: ClassDto) {
    this.defaultClass = classroom;

    this.classForm.patchValue({
      id: this.defaultClass.id!.toString(),
      year: this.defaultClass.year,
      grade: this.defaultClass.grade,
      group: this.defaultClass.group,
      field: this.defaultClass.field
    });
  }

}
