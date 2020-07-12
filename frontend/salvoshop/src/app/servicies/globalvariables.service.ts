import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalvariablesService {

  private currentPage: number;
  constructor() { }

  public getCurrentPage(): number {
    return this.currentPage;
  }

  public setCurrentPage(newPage: number) {
    this.currentPage = newPage;
  }
}
