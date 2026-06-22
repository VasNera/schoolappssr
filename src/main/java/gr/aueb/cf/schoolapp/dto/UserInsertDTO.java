package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserInsertDTO(


        @NotNull(message = "Το username δεν γίνεται να είναι κενό")
        @Size(min=2 , max=20 , message = "Το username πρέπει να είναι 2-20 χαρακτήρες")
        String username,

        @NotNull(message = "Το password δεν μπορεί να είναι κενό.")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])^.{8,}$",
        message = "Το password πρέπει να περιέχει τουλάχιστον ένα ψηφίο, ένα κεφαλαίο, ένα πεζό και έναν ειδικό χαρακτήρα.")
        String password,

        @NotNull(message = "Ο ρόλος δεν μπορεί να είναι κενός.")
        Long roleId
) {

    public static UserInsertDTO empty(){
        return new UserInsertDTO("", "", 0l);
    }
}
