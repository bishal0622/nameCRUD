import {Component, OnInit} from '@angular/core';
import {Name} from "./bid.model";
import {NameService} from "./bid.service";

@Component({
  selector: 'app-bid',
  templateUrl: './bid.component.html',
  styleUrls: ['./bid.component.css']
})
export class BidComponent implements OnInit {

  name: Name = {};
  names: any = [];

  flag = false;

  constructor(private nameService: NameService) {

  }

  ngOnInit() {
    this.loadAllData();
  }

  loadAllData() {
    this.nameService.query().subscribe((res) => this.names = res);
  }

  saveName() {
    this.nameService.create(this.name).subscribe(() => this.loadAllData())
  }

  delete(data) {
    this.nameService.delete(data.id).subscribe(() => this.loadAllData());
  }

  edit(data) {
    this.flag = true;
    this.name = this.names.filter(x => x.id == data.id)[0];
  }

  update() {
    this.nameService.update(this.name, this.name.id).subscribe(() => {
      this.loadAllData();
      this.flag= false;
    });
  }

}
