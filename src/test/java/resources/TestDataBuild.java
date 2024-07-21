package resources;

import pojo.AddUser;

public class TestDataBuild {


    public AddUser addUserPayLoad(String title, String firstName, String lastName, String dateOfBirth, String email, String password, int rating) {
        AddUser p = new AddUser();
        p.setTitle(title);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDateOfBirth(dateOfBirth);
        p.setEmail(email);
        p.setPassword(password);
        p.setRating(rating);
        return p;
    }

    public String deletePlacePayload(String placeId) {
        return "{\r\n    \"place_id\":\"" + placeId + "\"\r\n}";
    }
}
