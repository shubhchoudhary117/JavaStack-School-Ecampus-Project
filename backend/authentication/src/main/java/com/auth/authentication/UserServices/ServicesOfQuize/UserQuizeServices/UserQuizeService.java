package com.auth.authentication.UserServices.ServicesOfQuize.UserQuizeServices;
import java.util.*;
import com.auth.authentication.Entities.TestQuizes.Category.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;
public interface UserQuizeService{
    public Set<Quize> getAllQuizes();
    public Set<Quize> getQuizByCategory(Categories id);
    public Set<Quize> getActiveQuizes();
    public Set<Quize> getQuizeByActiveAndCategory(Categories category);

}
