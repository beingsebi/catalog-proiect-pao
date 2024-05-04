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

    public enum Days{
        MONDAY {
            public String toString() {
                return "Monday";
            }
        },
        TUESDAY {
            public String toString() {
                return "Tuesday";
            }
        },
        WEDNESDAY {
            public String toString() {
                return "Wednesday";
            }
        },
        THURSDAY {
            public String toString() {
                return "Thursday";
            }
        },
        FRIDAY {
            public String toString() {
                return "Friday";
            }
        },
        SATURDAY {
            public String toString() {
                return "Saturday";
            }
        },
        SUNDAY {
            public String toString() {
                return "Sunday";
            }
        }
    }
}
