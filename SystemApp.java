public class SystemApp {
    public static void main(String[] args) {
        Gym gym = new Gym();

        Member member1 = new Member("Johnny Saint", 18, "xonixxt@email.com", "83987654321");
        Member member2 = new Member("Maria Luiza", 17, "maluxxt@email.com", "83998765432");

        gym.addMember(member1);
        gym.addMember(member2);

        gym.activateMember(member1);
        gym.activateMember(member2);

        Plan planBasic = new Plan("Basic", 120.0, 3);
        Plan planPremium = new Plan("Premium", 300.0, 6);

        gym.assignPlanToMember(member1.getId(), planBasic);
        gym.assignPlanToMember(member2.getId(), planPremium);

        gym.listMembers();

        gym.getMemberPlanInfo(member1.getId());
        gym.getMemberPlanInfo(member2.getId());

        gym.updateMemberInfo(member1, 19, "83976543210", "xonixxt.oficial@email.com");

        gym.getMemberPlanInfo(member1.getId());

        gym.deactivateMember(member2);

        gym.removePlanFromMember(member2.getId());

        gym.listMembers();
    }
}
