public class Main {
    public static void main(String[] args) {

        Man nick = new Man("Mykola", "Pruchkovskiy", 38);


        Woman mila = new Woman("Mila", "Kalkutina", 20);

        mila.registerPartnership(nick);

        System.out.println(nick.getFirstName() + " and " + mila.getFirstName() + " are partners.");
        System.out.println(nick.getFirstName() + "'s last name is now: " + nick.getLastName());
        System.out.println(mila.getFirstName() + "'s last name is now: " + mila.getLastName());


        System.out.println(nick.getFirstName() + " is retired: " + nick.isRetired());
        System.out.println(mila.getFirstName() + " is retired: " + mila.isRetired());


        nick.setAge(70);
        mila.setAge(70);

        System.out.println(nick.getFirstName() + " is retired: " + nick.isRetired());
        System.out.println(mila.getFirstName() + " is retired: " + mila.isRetired());


        nick.deregisterPartnership(true);
        mila.deregisterPartnership(true);

        System.out.println(nick.getFirstName() + " and " + mila.getFirstName() + " are no longer partners.");
        System.out.println(nick.getFirstName() + "'s last name is now: " + nick.getLastName());
        System.out.println(mila.getFirstName() + "'s last name is now: " + mila.getLastName());
    }
}
