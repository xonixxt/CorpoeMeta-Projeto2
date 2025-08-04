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

    public Member findMemberById(int id){
        for (Member member : members){
            if (member.getId() == id){
                return member;
            }
        }
        throw new IllegalArgumentException("Member not found.");
    }

    public void deleteMember(Member memberToDelete) {
        Member member = findMemberById(memberToDelete.getId());
        members.remove(member);
        System.out.println("Member removed successfully. ID: " + member.getId());
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
        Member member = findMemberById(memberToActivate.getId());
        if (member.isActive()){
            throw new IllegalArgumentException("Member already activated. ID: " + member.getId());
        }
        member.setActive(true);
        System.out.println("Member activated successfully. ID: " + member.getId());
    }

    public void deactivateMember(Member memberToDeactivate){
        Member member = findMemberById(memberToDeactivate.getId());
        if (!member.isActive()){
            throw new IllegalArgumentException("Member already inactive. ID: " + member.getId());
        }
        member.setActive(false);
        System.out.println("Member deactivated successfully. ID: " + member.getId());
    }

    public void updateMemberInfo(Member memberToUpdate, Integer newAge, String newPhone, String newEmail) {
        Member member = findMemberById(memberToUpdate.getId());
        boolean updated = false;

        if (newAge != null && member.getAge() != newAge) {
            member.setAge(newAge);
            updated = true;
        }
        if (newPhone != null && !member.getPhone().equals(newPhone)) {
            member.setPhone(newPhone);
            updated = true;
        }
        if (newEmail != null && !member.getEmail().equals(newEmail)) {
            member.setEmail(newEmail);
            updated = true;
        }
        if (!updated) {
            throw new IllegalArgumentException("No new information provided to update.");
        }
        System.out.println("Member info updated successfully.");
    }
}
