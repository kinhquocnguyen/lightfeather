import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OldPasswordValidators, MatchPasswordValidators } from './password.validators';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent {
  form;

  constructor(fb: FormBuilder){
    this.form = fb.group({
      username: ['',[Validators.required]],
      email: ['',[Validators.required, Validators.email]],
      generatePassword: fb.group({
        newPassword: ['',Validators.required],
        confirmPassword: ['',Validators.required]
      })
    });
    this.form.get("generatePassword").setValidators(MatchPasswordValidators.checkMatchPassword());
  }

  get username(){
    return this.form.get('username');
  }

  get email(){
    return this.form.get('email');
  }

  get newPassword(){
    return this.form.get("generatePassword").get('newPassword');
  }

  get confirmPassword(){
    return this.form.get("generatePassword").get('confirmPassword');
  }

  submit(form){

  }
}
