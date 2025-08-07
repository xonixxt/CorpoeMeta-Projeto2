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

    public void assignPlanToMember(int memberId, Plan plan) {
        Member member = findMemberById(memberId);
        if (!member.isActive()) {
            throw new IllegalArgumentException("Cannot assign plan to inactive member. ID: " + memberId);
        }
        if (member.hasPlan()) {
            throw new IllegalArgumentException("Member already has a plan. ID: " + memberId);
        }
        member.setPlan(plan);
        System.out.println("Plan assigned successfully to member ID: " + memberId);
    }

    public void changePlan(int memberId, Plan newPlan) {
        Member member = findMemberById(memberId);
        if (!member.isActive()) {
            throw new IllegalArgumentException("Cannot change plan for inactive member. ID: " + memberId);
        }
        if (!member.hasPlan()) {
            throw new IllegalArgumentException("Member does not have a plan to change. ID: " + memberId);
        }
        member.setPlan(newPlan);
        System.out.println("Plan changed successfully for member ID: " + memberId);
    }

    public void removePlanFromMember(int memberId) {
        Member member = findMemberById(memberId);
        if (!member.isActive()) {
            throw new IllegalArgumentException("Cannot remove plan from inactive member. ID: " + memberId);
        }
        if (!member.hasPlan()) {
            throw new IllegalArgumentException("Member does not have a plan to remove. ID: " + memberId);
        }
        member.removePlan();
        System.out.println("Plan removed successfully from member ID: " + memberId);
    }

    public void getMemberPlanInfo(int memberId) {
        Member member = findMemberById(memberId);
        if (!member.hasPlan()) {
            System.out.println("Member ID " + memberId + " does not have a plan.");
            return;
        }
        Plan plan = member.getPlan();
        System.out.println("Plan info for member ID " + memberId + ":");
        System.out.println("Plan Name: " + plan.getName());
        System.out.println("Price: " + plan.getPrice());
        System.out.println("Duration (months): " + plan.getDurationMonths());
        System.out.println("Status: " + (plan.isActive() ? "Active" : "Inactive"));
    }
}
