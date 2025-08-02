import java.util.ArrayList;

public class Gym {
    private ArrayList<Member> members = new ArrayList<>();

    public void addMember(Member memberToAdd){
        for (Member member : members){
            if (memberToAdd.getId() == member.getId()){
                throw new IllegalArgumentException("Member already added.");
            }
        }
        members.add(memberToAdd);
    }

    public void listMembers(){
        if (members.isEmpty()){
            throw new IllegalArgumentException("Members list is empty.");
        }
        System.out.println("==== Members List ====");
        for (Member member : members){
            System.out.println("--------");
            System.out.println("Name: " + member.getName());
            System.out.println("ID: " + member.getId());
            System.out.println("Age: " + member.getAge() + " years.");
            System.out.println("Email: " + member.getEmail());
            System.out.println("Phone: " + member.getPhone());
            System.out.println("Status: " + (member.isActive() ? "Active" : "Inactive"));
        }
    }

    public void activateMember(Member memberToActivate) {
        for (Member member : members) {
            if (member.getId() == memberToActivate.getId()) {
                if (member.isActive() == true){
                    throw new IllegalArgumentException("Status already active.");
                }
                member.setActive(true);
                System.out.println("Member activated successfully.");
                return;
            }
        }
    }
    public void desactivateMember(Member memberToDesactive){
        for (Member member : members){
            if (member.getId() == memberToDesactive.getId()){
                if (member.isActive() == false){
                    throw new IllegalArgumentException("Member already inactive.");
                }
                member.setActive(false);
                System.out.println("Member deactivated successfully.");
                return;
            }
        }
    }
}
