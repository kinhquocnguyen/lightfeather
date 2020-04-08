import { AbstractControl, ValidationErrors, ValidatorFn, FormGroup } from '@angular/forms';


export class MatchPasswordValidators{
    
    static checkMatchPassword(): ValidatorFn{
        return (generatePassword: FormGroup): ValidationErrors => {
            const newPassword = generatePassword.controls['newPassword'];
            const confirmPassword = generatePassword.controls['confirmPassword'];
            if (newPassword.value !== confirmPassword.value){
                confirmPassword.setErrors({notEquivalent: true});
            }else{
                confirmPassword.setErrors(null);
            }
            return;
        }

    }
}