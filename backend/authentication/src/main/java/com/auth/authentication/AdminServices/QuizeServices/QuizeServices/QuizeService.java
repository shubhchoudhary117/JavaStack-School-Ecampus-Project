package com.auth.authentication.AdminServices.QuizeServices.QuizeServices;
import java.util.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;

public interface QuizeService {
    public Quize addQuize(Quize quize);
    public Set<Quize> getQuizes();
    public Quize getQuizeById(int id);
    public void deleteQuize(int id);
}
