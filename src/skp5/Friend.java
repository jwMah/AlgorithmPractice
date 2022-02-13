package skp5;

import java.util.*;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        Set<Friend> set = new HashSet<>();
        Queue<Friend> queue = new LinkedList<>();
        queue.offer(this);
        set.add(this);
        while(!queue.isEmpty()) {
            Friend f = queue.poll();
            if(f.getEmail().equals(friend.getEmail())) { //친구 발견
                return true;
            }
            Collection<Friend> c = f.getFriends();
            for (Friend friend1 : c) {
                if(!set.contains(friend1)) {
                    queue.offer(friend1);
                    set.add(friend1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(d));
    }
}