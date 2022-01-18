package samsungDXNo3;

import java.util.ArrayList;
import java.util.HashMap;

class UserSolution {

    class Member {
        char[] name;
        int sex;
        int idx;
        Member spouse; //배우자
        ArrayList<Member> parent = new ArrayList<>();
        ArrayList<Member> children = new ArrayList<>();
        public Member(char[] name, int sex, int idx) {
            this.name = name;
            this.sex = sex;
            this.idx = idx;
        }
        public char[] getName() {
            return name;
        }
        public void setName(char[] name) {
            this.name = name;
        }
        public int getSex() {
            return sex;
        }
        public void setSex(int sex) {
            this.sex = sex;
        }
        public Member getSpouse() {
            return spouse;
        }
        public void setSpouse(Member spouse) {
            this.spouse = spouse;
        }
        public ArrayList<Member> getParent() {
            return parent;
        }
        public void setParent(Member parent) {
            this.parent.add(parent);
        }
        public ArrayList<Member> getChildren() {
            return children;
        }
        public void setChildren(Member children) {
            this.children.add(children);
        }
    }

    static ArrayList<Member> list;
    static int count,list_idx;

    int mstrcmp(char[] a, char[] b) {
        //두 멤버의 이름이 같으면 0 반환, 아니면 0이 아닌 수 반환
        int i;
        for (i = 0; a[i] != '\0'; i++) {
            if (a[i] != b[i])
                return a[i] - b[i];
        }
        return a[i] - b[i];
    }

    int mstrlen(char[] a) {
        // \0 전까지의 멤버 이름의 길이를 반환
        int len = 0;

        while (a[len] != '\0')
            len++;

        return len;
    }

    void mstrcpy(char[] dest, char[] src) {
        //src의 이름을 dest로 복사
        int i = 0;
        while (src[i] != '\0') {
            dest[i] = src[i];
            i++;
        }
        dest[i] = src[i];
    }


    void init(char initialMemberName[], int initialMemberSex) {
        list = new ArrayList<>();
        list_idx = 0;
        list.add(new Member(initialMemberName,initialMemberSex,list_idx));
        list_idx++;
    }

    boolean addMember(char newMemberName[], int newMemberSex, int relationship, char existingMemberName[]) {
        Member existMember = new Member(new char[]{'h'},-1,-1);
        Member newMember = new Member(newMemberName,newMemberSex,list_idx);
        list_idx++;
        for (Member temp : list) {
            if(mstrcmp(existingMemberName,temp.getName()) == 0) {
                existMember = temp;
                break;
            }
        }
        switch (relationship) {
            case 0: //배우자 추가
                if(existMember.getSpouse() != null || newMemberSex == existMember.getSex()) {
                    list_idx--;
                    break;
                }

                existMember.setSpouse(newMember); newMember.setSpouse(existMember);
                for (Member child : existMember.getChildren()) {
                    child.setParent(newMember);
                    newMember.setChildren(child);
                }
                list.add(newMember);
                return true;
            case 1: //부모 추가
                for (Member parMember : existMember.getParent()) {
                    if(parMember.getSex() == newMemberSex) {
                        list_idx--;
                        return false;
                    }
                }
                existMember.setParent(newMember); newMember.setChildren(existMember);
                if(existMember.getParent().size() == 2) {
                    existMember.getParent().get(0).setSpouse(newMember);
                    newMember.setSpouse(existMember.getParent().get(0));
                    for(Member child :newMember.getSpouse().getChildren()) {
                        newMember.setChildren(child);
                        child.setParent(newMember);
                    }
                }
                list.add(newMember);
                return true;
            case 2: // 자식 추가
                existMember.setChildren(newMember);
                newMember.setParent(existMember);
                if(existMember.getSpouse() != null) {
                    existMember.getSpouse().setChildren(newMember);
                    newMember.setParent(existMember.getSpouse());
                }
                list.add(newMember);
                return true;
        }
        return false;
    }

    int getDistance(char nameA[], char nameB[]) {

        return -1;
    }

    int countMember(char name[], int dist) {
        //name에 해당하는 멤버를 찾은 뒤, visited

        count = 0;
        boolean[] check = new boolean[list.size()];
        for (Member member : list) {
            if(mstrcmp(name,member.getName()) == 0) {
                //System.out.println(member.name);
                check[member.idx] = true;
                countMember_dfs(member,dist,0,check);
            }
        }
        return count;
    }

    private void countMember_dfs(Member member, int dist, int a, boolean[] check) {
        if(dist < a)
            return;
        if(dist == a) {
            //System.out.println(member.name);
            count++;
        }
        if(member.getSpouse() != null && !check[member.getSpouse().idx]) { //배우자가 있다
            check[member.getSpouse().idx] = true;
            countMember_dfs(member.getSpouse(),dist,a,check);
            check[member.getSpouse().idx] = false;
        }
        for (Member parMember : member.getParent()) { //부모가 있다
            if(!check[parMember.idx]) {
                check[parMember.idx] = true;
                countMember_dfs(parMember,dist,a+1,check);
                check[parMember.idx] = false;
            }
        }
        for (Member child : member.getChildren()) {
            if(!check[child.idx]) {
                check[child.idx] = true;
                countMember_dfs(child,dist,a+1,check);
                check[child.idx] = false;
            }
        }

    }
}
