public class SystemApp {
    public static void main(String[] args) {
        Gym gym = new Gym();

        Person person1 = new Person("Johnny Saint", 18, "xonixxt@email.com", "83987654321");
        Person person2 = new Person("Maria Luiza", 17, "maluxxt@email.com", "83998765432");

        gym.addMember(person1);
        gym.addMember(person2);

        gym.activateMember(person1);
        gym.activateMember(person2);

        Plan planBasic = new Plan("Basic", 120.0, 3);
        Plan planPremium = new Plan("Premium", 300.0, 6);

        gym.assignPlanToMember(person1.getId(), planBasic);
        gym.assignPlanToMember(person2.getId(), planPremium);

        gym.listMembers();

        gym.getMemberPlanInfo(person1.getId());
        gym.getMemberPlanInfo(person2.getId());

        gym.updateMemberInfo(person1, 19, "83976543210", "xonixxt.oficial@email.com");

        gym.getMemberPlanInfo(person1.getId());

        gym.deactivateMember(person2);

        gym.removePlanFromMember(person2.getId());

        gym.listMembers();
    }
}
