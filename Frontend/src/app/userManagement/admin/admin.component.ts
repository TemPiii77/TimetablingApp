import {Component, OnInit} from '@angular/core';
import {AdminDto} from "../../dto/admin-dto";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit{

  admins: AdminDto[] = [];

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.adminService.listAdmins();

    this.adminService.admins$.subscribe(resultData => {
      this.admins = resultData;
    });
  }

}
