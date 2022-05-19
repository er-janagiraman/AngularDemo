import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
declare var $:any;

export interface CommonDto{
  responseData: any;
  responseDto: any;
  status: string;
}
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  dataList:any;

  constructor(private service :AuthService) { }

  ngOnInit(): void {
    
    this.dtable();
  }

  dtable(){
    this.service.fetch().subscribe((response:CommonDto)=>{
      this.dataList=response.responseDto;
      $(document).ready(function () {
        $('#table').DataTable();
    });
      console.log(this.dataList);
    })
  }

}
