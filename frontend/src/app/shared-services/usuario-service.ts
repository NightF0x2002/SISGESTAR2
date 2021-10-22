import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {UsuarioModel} from '../shared-models/usuario-model';
import { BaseEntityService } from '../utils/base-entity-service';

@Injectable({
    providedIn: 'root'
})export class UsuarioService extends BaseEntityService<UsuarioModel, any> {

    constructor(protected http: HttpClient) {
        super(http)
    }

    getEntity() {
        return 'usuarios';
    }
    
    login(hash: string) {
        return this.http.get<UsuarioModel>(this.resourceUrl + '/obter-por-hash/' + hash);
    }

}
