import {booleanAttribute, Component, OnChanges, OnInit, SimpleChanges, ViewChild, ViewContainerRef} from '@angular/core';
import {ClassroomService} from "../../service/classroom.service";
import {ClassroomDto} from "../../dto/classroom-dto";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-classroom',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './classroom.component.html',
  styleUrl: './classroom.component.css'
})
export class ClassroomComponent implements OnInit{

  classrooms: ClassroomDto[] = [];
  defaultClassroom: ClassroomDto | undefined;

  classroomForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    type: new FormControl(''),
    doubleSize: new FormControl(<boolean | null>null),
  })

  constructor(private classroomService: ClassroomService) {}

  ngOnInit(): void {
    this.classroomService.listClassrooms();

    this.classroomService.classrooms$.subscribe(resultData => {
      this.classrooms = resultData;
    });
  }

  saveClassroom(newClassroom: ClassroomDto): void {
    this.classroomService.saveClassroom(newClassroom)
    this.classroomService.listClassrooms();
  }

  deleteClassroom(id: number): void {
    this.classroomService.deleteClassroom(id).subscribe(() => {
      this.classroomService.listClassrooms();
    });
  }

  updateClassroom(updatedClassroom: ClassroomDto): void {
    this.classroomService.updateClassroom(updatedClassroom)
    this.classroomService.listClassrooms();
  }

  handleSubmit(event: any) {
    const classroom = {
      id: this.classroomForm.value.id ? Number(this.classroomForm.value.id) : 0,
      name: this.classroomForm.value.name!,
      type: this.classroomForm.value.type!,
      doubleSize: this.classroomForm.value.doubleSize
    };

    if(event.submitter.name == "save") {
      this.saveClassroom(classroom);
    }
    else if(event.submitter.name == "update") {
      this.updateClassroom(classroom);
    }
  }

  updateClassroomForm(classroom: ClassroomDto) {
    this.defaultClassroom = classroom;

    this.classroomForm.patchValue({
      id: this.defaultClassroom.id!.toString(),
      name: this.defaultClassroom.name,
      type: this.defaultClassroom.type,
      doubleSize: this.defaultClassroom.doubleSize
    });
  }
}
