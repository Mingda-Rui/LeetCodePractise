package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class _7_7ChatServer {
  // User
  //

  // ChatRoom
  //

  // Message
  //

  // ChatManager
  // createNewChat

  // UserManager
  // signUpUser
  // findUser
}

/* UserManager serves as a central place for core user actions */
class ChatServerUserManager {
  private static ChatServerUserManager instance;

  /* maps from a user id to a user */
  private HashMap<Integer, ChatServerUser> usersById;

  /* maps from an account name to a user */
  private HashMap<String, ChatServerUser> usersByAccountName;

  /* maps from the user id to an online user */
  private HashMap<Integer, ChatServerUser> onlineUsers;

  public static ChatServerUserManager getInstance() {
    if (instance == null) {
      instance = new ChatServerUserManager();
    }
    return instance;
  }

  public void addUser(ChatServerUser fromUser, String toAccountName) {}

  public void approveAddRequest(AddRequest req) {}

  public void rejectAddRequest(AddRequest req) {}

  public void userSignedOn(String accountName) {}

  public void userSignedOff(String accountName) {}
}

class ChatServerUser {
  private int id;
  private UserStatus status = null;

  /* maps from the other participant's user id to the chat */
  private HashMap<Integer, PrivateChat> privateChats;

  /* list of group chats */
  private ArrayList<GroupChat> groupChats;

  /* maps from the other person's user id to the add request */
  private HashMap<Integer, AddRequest> receivedAddRequests;

  /* maps from the other person's user id to the add request */
  private HashMap<Integer, AddRequest> sentAddRequests;

  /* maps from the user id to user object */
  private HashMap<Integer, ChatServerUser> contacts;

  private String accountName;
  private String fullName;

  public ChatServerUser(int id, String accountName, String fullName) {}

  public boolean sendMessageToUser(ChatServerUser to, String content) {
    // ...
    return false;
  }

  public boolean sendMessageToGroupChat(int id, String cnt) {
    // ...
    return false;
  }

  public void setStatus(UserStatus status) {}

  public boolean addContact(ChatServerUser user) {
    // ...
    return false;
  }

  public void receivedAddRequest(AddRequest req) {}

  public void sentAddRequest(AddRequest req) {}

  public void removeAddRequest(AddRequest req) {}

  public void requestAddUser(String accountName) {}

  public void addConversation(PrivateChat conversation) {}

  public void addConversation(GroupChat conversation) {}

  public int getId() {
    return id;
  }

  public String getAccountName() {
    return accountName;
  }

  public String getFullName() {
    // ...
    return "";
  }
}

abstract class Conversation {
  protected ArrayList<ChatServerUser> participants;
  protected int id;
  protected ArrayList<Message> messages;

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public boolean addMessage(Message m) {
    return messages.add(m);
  }

  public int getId() {
    return id;
  }
}

class GroupChat extends Conversation {
  public void removeParticipant(ChatServerUser user) {}

  public void addParticipant(ChatServerUser user) {}
}

class PrivateChat extends Conversation {
  public PrivateChat(ChatServerUser user1, ChatServerUser user2) {}

  public ChatServerUser getOtherParticipant(ChatServerUser user) {
    // ...
    return null;
  }
}

class Message {
  private String content;
  private Date date;

  public Message(String content, Date date) {}

  public String getContent() {
    return content;
  }

  public Date getDate() {
    return date;
  }
}

class AddRequest {
  private ChatServerUser fromUser;
  private ChatServerUser toUser;
  private Date date;
  RequestStatus status;

  public AddRequest(ChatServerUser from, ChatServerUser to, Date data) {}

  public RequestStatus getStatus() {
    return status;
  }

  public ChatServerUser getFromUser() {
    return fromUser;
  }

  public ChatServerUser getToUser() {
    return toUser;
  }

  public Date getDate() {
    return date;
  }
}

class UserStatus {
  private String message;
  private UserStatusType type;

  public UserStatus(UserStatusType type, String message) {}

  public UserStatusType getStatusType() {
    return type;
  }

  public String getMessage() {
    return message;
  }
}

enum UserStatusType {
  Offline,
  Away,
  Idle,
  Available,
  Busy
}

enum RequestStatus {
  Unread,
  Read,
  Accepted,
  Rejected
}
