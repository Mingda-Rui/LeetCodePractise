package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.List;

public class _7_2CallCenter {}

class CallHandler {

  /* 3 levels of employees: respondents, managers, directors */
  private final int LEVEL = 3;

  /* Initialize 10 respondents, 4 managers, and 2 directors. */
  private final int NUM_RESPONDENTS = 10;
  private final int NUM_MANAGERS = 4;
  private final int NUM_DIRECTORS = 2;

  /* List of employees, by level.
   * employeeLevels[0] = respondents
   * employeeLevels[1] = managers
   * employeeLevels[2] = directors
   * */
  List<List<Employee>> employeeLevels;

  /* queues for each call's rank */
  List<List<Call>> callQueues;

  public CallHandler() {
    // ...
  }

  /* Gets the first available employee who can handle this call. */
  public Employee getHandlerForCall(Call call) {
    // ...
    return null;
  }

  /* Routes the call to an available employee, or saves in a queue if no employee
   * is available
   */
  public void dispatchCall(Caller caller) {
    Call call = new Call(caller);
    dispatchCall(call);
  }

  /* Routes the call to an available employee, or saves in a queue if no employee
   * is available */
  public void dispatchCall(Call call) {
    /* Try to route the call to an employee with minimal rank. */
    Employee emp = getHandlerForCall(call);
    if (emp != null) {
      emp.receiveCall(call);
      call.setHandler(emp);
    } else {
      /* Place the call into corresponding call queue according to its rank. */
      call.reply("Please wait for free employee to reply");
      callQueues.get(call.getRank().ordinal()).add(call);
    }
  }

  /* An employee got free. Look for a waiting call that employee can serve. Return
   * true if we assigned a call, false otherwise. */
  public boolean assignCall(Employee emp) {
    // ...
    return false;
  }
}

class Caller {}

class Call {

  /* Minimal rank of employee who can handle this call. */
  private Rank rank;

  /* Person who is calling. */
  private Caller caller;

  /* Employee who is handling the call. */
  private Employee handler;

  public Call(Caller c) {
    rank = Rank.Responder;
    caller = c;
  }

  /* Set employee who is handling call. */
  public void setHandler(Employee e) {
    handler = e;
  }

  public void reply(String message) {
    // ...
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public Rank increaseRank() {
    // ...
    return null;
  }

  public void disconnect() {
    // ...
  }
}

enum Rank {
  Respondent,
  Manager,
  Director,
  Responder,
}

abstract class Employee {

  private Call currentCall = null;
  protected Rank rank;

  public Employee() {}

  public Employee(CallHandler handler) {
    // ...
  }

  /* Start the conversation */
  public void receiveCall(Call call) {
    // ...
  }

  /* the issue is resolved, finish the call */
  public void callCompleted() {
    // ...
  }

  /* The issue has not been resolved. Escalate the call, and assign a new call to
   * the employee.
   * */
  public void escalateAndReassign() {
    // ...
  }

  /* Assign a new call to an employee, if the employee is free. */
  public boolean assignNewCall() {
    // ...
    return false;
  }

  /*Returns whether or not the employee is free. */
  public boolean isFree() {
    return currentCall == null;
  }

  public Rank getRank() {
    return rank;
  }
}

class Director extends Employee {

  public Director() {
    rank = Rank.Director;
  }
}

class Manager extends Employee {

  public Manager() {
    rank = Rank.Manager;
  }
}

class Respondent extends Employee {

  public Respondent() {
    rank = Rank.Respondent;
  }
}
