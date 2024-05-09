package shared;

public class Constants {

    public enum Gender {

        MALE {
            public String toString() {
                return "MALE";
            }
        },

        FEMALE {
            public String toString() {
                return "FEMALE";
            }
        }
    }

    public enum Days {
        MONDAY {
            public String toString() {
                return "MONDAY";
            }
        },
        TUESDAY {
            public String toString() {
                return "TUESDAY";
            }
        },
        WEDNESDAY {
            public String toString() {
                return "WEDNESDAY";
            }
        },
        THURSDAY {
            public String toString() {
                return "THURSDAY";
            }
        },
        FRIDAY {
            public String toString() {
                return "FRIDAY";
            }
        },
        SATURDAY {
            public String toString() {
                return "SATURDAY";
            }
        },
        SUNDAY {
            public String toString() {
                return "SUNDAY";
            }
        }
    }
}
