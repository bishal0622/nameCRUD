import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Name} from "./bid.model";

@Injectable()
export class NameService {

  private resourceUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {

  }

  create(data: Name) {
    console.log(data)
    return this.http.post(this.resourceUrl, data);
  }

  query() {
    return this.http.get(this.resourceUrl);
  }

  find(id: number) {
    return this.http.get(`${this.resourceUrl}/${id}`);
  }

  update(data: Name, id : number) {
    return this.http.put(`${this.resourceUrl}/${id}`, data);
  }

  delete(id: number) {
    return this.http.delete(`${this.resourceUrl}/${id}`);
  }

}
