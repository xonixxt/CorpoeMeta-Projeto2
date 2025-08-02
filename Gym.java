import java.util.ArrayList;

public class Gym {
    private ArrayList<Member> members = new ArrayList<>();

    public void addMember(Member memberToAdd){
        for (Member member : members){
            if (memberToAdd.getId() == member.getId()){
                throw new IllegalArgumentException("Member already added with ID: " + memberToAdd.getId());
            }
        }
        members.add(memberToAdd);
        System.out.println("Member added successfully. ID: " + memberToAdd.getId());
    }

    public void deleteMember(Member memberToDelete) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == memberToDelete.getId()) {
                members.remove(i);
                System.out.println("Member removed successfully. ID: " + memberToDelete.getId());
                return;
            }
        }
        throw new IllegalArgumentException("Member not found with ID: " + memberToDelete.getId());
    }

    public void listMembers(){
        if (members.isEmpty()){
            throw new IllegalArgumentException("Members list is empty. No members to list.");
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

    public void activateMember(Member memberToActivate){
        for (Member member : members){
            if (member.getId() == memberToActivate.getId()){
                if (member.isActive()){
                    throw new IllegalArgumentException("Member already activated. ID: " + member.getId());
                }
                member.setActive(true);
                System.out.println("Member activated successfully. ID: " + member.getId());
                return;
            }
        }
        throw new IllegalArgumentException("Member not found with ID: " + memberToActivate.getId());
    }

    public void deactivateMember(Member memberToDeactivate){
        for (Member member : members){
            if (member.getId() == memberToDeactivate.getId()){
                if (!member.isActive()){
                    throw new IllegalArgumentException("Member already inactive. ID: " + member.getId());
                }
                member.setActive(false);
                System.out.println("Member deactivated successfully. ID: " + member.getId());
                return;
            }
        }
        throw new IllegalArgumentException("Member not found with ID: " + memberToDeactivate.getId());
    }
}
