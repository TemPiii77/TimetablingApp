import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {UserDto} from "../../dto/user-dto";
import {UserService} from "../../service/user.service";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {StudentClassService} from "../../service/student-class.service";
import {StudentClassIdDto} from "../../dto/student-class-id-dto";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatOption} from "@angular/material/core";
import {MatSelect} from "@angular/material/select";
import {MatPaginator} from "@angular/material/paginator";
import {MatCell, MatCellDef, MatColumnDef, MatHeaderCell, MatHeaderCellDef, MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef, MatTable, MatTableDataSource} from "@angular/material/table";
import {MatIcon} from "@angular/material/icon";

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatInput,
    MatLabel,
    MatButton,
    MatOption,
    MatSelect,
    MatPaginator,
    MatTable,
    MatIcon,
    MatIconButton,
    MatHeaderCell,
    MatCell,
    MatHeaderRow,
    MatRow,
    MatColumnDef,
    MatCellDef,
    MatHeaderCellDef,
    MatHeaderRowDef,
    MatRowDef
  ],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit, AfterViewInit{

  users: UserDto[] = [];
  defaultUser: UserDto | undefined;
  classes: ClassDto[] = [];
  dataSource = new MatTableDataSource(this.users);
  displayedColumns: string[] = ['id', 'email', 'lastName', 'firstName', 'password', 'role', 'actions'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  userForm = new FormGroup({
    id: new FormControl(''),
    email: new FormControl(''),
    lastName: new FormControl(''),
    firstName: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl(''),
    roleBasedInformation: new FormControl(''),
    classId: new FormControl('')
  })

  constructor(private userService: UserService,
              private classService: ClassService,
              private studentClassService: StudentClassService) {}

  ngOnInit(): void {
    this.userService.listUsers();
    this.classService.listClasses();

    this.userService.users$.subscribe(resultData => {
      this.users = resultData;
      this.dataSource = new MatTableDataSource(this.users);
      this.dataSource.paginator = this.paginator;

    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });
  }

  saveUser(newUser: UserDto, roleBasedInformation: string): void {
    this.userService.saveUser(newUser, roleBasedInformation)
    this.userService.listUsers();
  }

  deleteUser(id: string): void {
    this.userService.deleteUser(id).subscribe(() => {
      this.userService.listUsers();
    });
  }

  updateUser(updatedUser: UserDto, roleBasedInformation: string): void {
    this.userService.updateUser(updatedUser, roleBasedInformation)
    this.userService.listUsers();
  }

  handleSubmit(event: any) {
    const user = {
      id: this.userForm.value.id!,
      email: this.userForm.value.email!,
      lastName: this.userForm.value.lastName!,
      firstName: this.userForm.value.firstName!,
      password: this.userForm.value.password!,
      role: this.userForm.value.role!,
    };

    let roleBasedInformation = this.userForm.value.roleBasedInformation;

    if(event.submitter.name == "save") {
      this.saveUser(user, roleBasedInformation!);
      if(this.userForm.value.classId != null) {

        const studentClassId = {
          studentId: user.id,
          classId: this.userForm.value.classId ? Number(this.userForm.value.classId) : 0
        }
        this.studentClassService.saveStudentClass(studentClassId)
      }
    }
    else if(event.submitter.name == "update") {
      this.updateUser(user,roleBasedInformation!);
      this.userForm.get('id')?.setValue(null);
    }
  }

  updateUserForm(user: UserDto) {
    this.defaultUser = user;

    this.userForm.patchValue({
      id: this.defaultUser.id,
      email: this.defaultUser.email,
      lastName: this.defaultUser.lastName,
      firstName: this.defaultUser.firstName,
      password: this.defaultUser.password,
      role: this.defaultUser.role,
    });
  }

  formatFields(subjectRequirement: any): string {
    return Object.values(subjectRequirement).join(' - ');
  }
}
