package shared;

public class Constants {

    public enum Gender {

        MALE {
            public String toString() {
                return "Male";
            }
        },

        FEMALE {
            public String toString() {
                return "Female";
            }
        }
    }
}
