# Design Patterns

[YouTube Tutorial](https://www.youtube.com/watch?v=mE3qTp1TEbg&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc)

Patterns will not generate ready code for us.
Instead, they provide us a template to follows.
They are a series of formalized best practices tested and verified by developers.

From the book: *Design Patterns* by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides.
Also called *Gang of Four (GoF) book* which categorises 23 patterns into 3 groups:
- **Creational** provides more flexibility in how the objects are actually created (Builder Pattern).
- **Structural** deals with how *Inheritance* and *Composition* can be used to provide extra functionality (Flyweight Pattern).
- **Behavioral** are about *communication* and *assignment of responsibilities* between our objects (Memento Pattern).

## Creational Design Patterns

### Singleton

- Only one instance of its kind exists.
- Provides a single point of access to it from any other part of our application.
- Encapsulates the attributes of an object in one single class.
- getInstance() will return an already existing instance, or a new instance if not already initialized.
- code needs to be adapted to handle multiple threads.

Example: Database Object.

### Factory Method

Real Life Scenario: Restaurant

Compared to **Simple Factory Idiom** technique, if we want to add more recipes to our menu, we will have to make changes to the createBurger() method.
To fix this, we use the Factory Method Design Pattern

- Create a class whose sole responsibility is understood.
- Loosens the coupling of a given code by separating the product's construction code from the code that uses this product. 

When should we use it?
- If we have no idea of the exact types of the objects our code will work with.

Limitation of Factory Method:
- What if we want to deliver our food, in an Italian way? This will again require us to pass the request object to the `abstract` `createBurger` method. 
- This means our code is again open for modification. Also, our code may break this way. 
- It also VIOLATES the OPEN-CLOSED Principle.

The next design pattern has the solution.

### Abstract Factory

Real Life Scenario: Manufacturers and Products

Why Factory Method fails?
- A single factory is not enough
- We should scale up the implementation to use the abstract factory design pattern.

What is Abstract Factory?
- Allows us to produce **families  of related objects** without specifying their concrete classes.
- Forces us to **explicitly declare interface**s for **each distinct product** we have.
- Relies heavily on inheritance, so it delegates object creation to subclasses that implement the factory method.
- Lets creator-subclasses decide which class to instantiate.
- Makes it easy to **extend the product construction code** independently of the rest of the application.
- Allows **introducing new products** without breaking existing code.
- Follows **Open Closed** and **Single Responsibility** principles.
- Centralizes the product creation code in one place in the program.

When should we use it?
- When our code needs to work with **various families** of related products.

NOTE:
Many designs start by using the Factory Method pattern and later evolve towards an Abstract Factory design.

Example: We should have two interfaces each for Gpu and Monitor that a company manufactures instead of using one common interface for all.

### Builder

- Lets us create complex objects on a step-by-step basis.
- Produces different types and representations of an object using the same construction process.
- Extracts the object construction or **creation code** out of its own class and move it to separate objects called builders.
- Forces us to **instantiate** our object **using the builder**.
- Separates the construction of ann object from its representation.

When should we use it?
- We may not need to fill **all** the fields of an object.

#### Director

Why?
Consider the shared similarities in the object calls for builder.
For example, a Bugatti car can **share** few attributes with a Lambo car.
We can extract all such common attributes separately.

What?
- Defines **the order** in which we should call the construction steps so that we can **reuse** specific **configurations** of the products we are building.
- Hides the details of the product construction from the client code.

Client must create both the builder and the director.

Director is optional but handy.

### Prototype

- Delegates the object duplication or cloning process to the actual objects that are being cloned without coupling the creation of an object to its class. 
- Example: A car class may have private members which may create problems when creating deep copies of an object. 
- Also, there could be scenarios where we may not know which implementation of **Vehicle** interface to go for.
- With the help of the `clone()` method, we not only decoupled the creation of the application logic from our class but also we gave access to our object's private fields.

Solution: 
- Design **Prototype** interface that contains `clone()` method that returns a hard copy of the object.
- OR an abstract class with abstract clone method for subclasses to implement.

When should I use it?
- When we don't want  our code to depend on the concrete classes of the objects that we need to copy or duplicate.

How?
- Will clone objects **without coupling** them to their concrete classes.
- Will get rid of repeated initialization code.

#### Prototype Registry

- To store **frequently** accessed prototypes.
- A **centralized** place, a catalog for the **prototypes** you **use** and clone **the most**.
- Typically, implemented as new **factory** class.

## Behavioral Design Patterns

### Chain of Responsibility

- Transform particular **behaviors** into stand-alone objects called **handlers**.
- Upon receiving a request, the request will pass along a chain of handlers where each decides either to:
 - Process the request, OR
 - Pass it to the next handler.
- Allows us to Insert, Remove, or Reorder handlers dynamically.
- Client may trigger any handler in the chain, not just the first one.

When should I use it?
- When we encounter the need to **execute** several **handlers in a particular order**.

### Command

Real Life Scenario: Smart Home Automation - Light Switching

Why do we need it?
- Having an **enormous number of subclasses** increases the risk of breaking the code in any subclass everytime we modify the parent class. 
  - Example: Bathroom class does not need automated switching but still has to extend the Room class. 
  - Parent class: Room should not have the business logic for switching functionality. 
  - Our app should give **flexibility** to remove this feature from the Bathroom class.
- The invoked operation might need to be called from **multiple places** in our application. 
  - Example: FloorLamp which is not a Room, cannot extend Room, hence needs to have it's own logic to switch lights. 
- However, several classes will call this logic and this **violates** the **Single Responsibility** principle.

This is solved by the Command Pattern.

- Turns a request, or a **behavior** into a **stand-alone object** that contains everything about that request.
- **Encapsulates** all the relevant information needed to perform an action or **trigger** an event so that this action can be **reused** by several parts of our application.
- Opens a lot of interesting uses: such as passing **commands as method arguments**, storing them inside other objects or even **switching commands at runtime**.
- Commands can be **serialized**, making it easy to **write** it to and **read** it from a file.

Advantage?
- Possibilities for construction are endless.
- Every class has its **own responsibility** now as we managed to decouple the classes that invoke operations from the classes that actually perform these operations.
- The decisions, the assignments and the configuration of our program is now decided at runtime by the client giving him flexibility with what and how to do at hand.

Two terms associated with Command Pattern:
- **Invoker** (or Sender) responsible for initiating requests. It triggers the command instead of sending the request directly to the receiver (Rooms is our case)
- **Receiver** contains business logic. In our example, the command we created was redirecting the call from the *Room* class to the *Light* class to inform to switch the lights.
  - The actual switching (actual business logic) is being done inside the *Light* class and not inside the *Command* itself.

### Template Method

Real Life Scenario: Game Loading Screen example.

- Data loading from Disk Storage to RAM
- Huge Multimedia games have to create way more objects than any actual app.
  - May also need to **download** external data.
  - May also need to delete temporary data
  - May also need to load previously saved profiles.

Why Template Method?
We must create a single method that contains the business logic to load all the required components in a specific order.
But what if we need to create `load()` method for several other Games and then we may face some data transfer and objects creation which is common among few games.
Template Method solves such duplication issue in this case.

Why Template Method?
- Defines the **skeleton** of an algorithm in the **superclass** but lets subclasses **override specific steps** of the algorithm without changing its structure.

How Template Method works?
- Break down the algorithm into a series of methods.
- Put a series of calls to these methods or steps inside a single **template method** (which in our case is `load()` method)
- The steps may either be abstract, or have some default implementation inside the parent class.
- To use the algorithm, the client must provide its own subclass and implement all abstract steps. If need arrives, override some of the optional ones but not the template method itself.

### Mediator

Real Life Scenario: How do the Pilots know when to land the plane?

Solution: Air Traffic Controller (Mediator) - a single point of contact for all the planes.

What is Mediator Design Pattern?
- Defines an object that **encapsulates** how a set of other objects interact with one another.
- Restricts direct communications between objects and forces them to **collaborate via a mediator** hence reducing the dependencies between them.

Various parts of Mediator Pattern:
- **Components** (Buttons / Labels / Text) fields in our app. They have a reference to the interface of the mediator allowing us to reuse this component in other programs.
- **Mediator** Interface: The jop of this interface is to declare the methods in which the means of communication between our components is specified.
- **Concrete Mediators**: Encapsulate relations between the various components they manage.

**NOTE**: 
Components may pass any context as argument to the method (including their own object).
However, this should be done in a way that **NO COUPLING** occurs between the receiving component and the sender's class.

Advantages:
- Extracts all the **relationships** between your classes into a separate class.
- Classes will:
 - be decoupled from one another.
 - communicate indirectly via the mediator.
- Allows us to **resuse any component** in a different application.
- It is easy to **define new ways** in which these **components communicate** by introducing new mediator classes.

### Memento

Real Life Scenario: Undo in Text typing.

Solves the problem of **Broken Encapsulation**.

Solved by the concept of **Nested classes** to prevent data privacy.

Broken Encapsulation?
Objects **invade the private space** of other objects instead of letting these objects perform the actual action.

What is Memento Design Pattern?
- Delegates **creating the state** snapshots to the actual **owner of that state**. 
- Hence, the **original class** can make the snapshots since it has **full access** to its own state.
- Lets us **save and restore** the state of an object **without revealing** the details of **its implementation**.

NOTE:
- It is the best practise to make the Memento Immutable and initialize it only once using the constructor.

Key Terminologies:
- **Originator** (TextArea class): **produces snapshots** of its own state; **restores its state** from snapshots.
- **Memento** (Inner class within originator): acts as a **snapshot** of the originator's state
- **Caretaker** (Editor class): responsible for **capturing** and **restoring** the originator state.

### Observer (Pub-Sub Model)

Real Life Scenario: Subscription Mechanism (Customers can choose when and based on what to be notified!)

What?
- Allows us to **change** or **take action on a set of objects** when and if the state of **another object changes**.
- **Notifies** multiple objects, or **subscribers**, about any events that happen to the object they're observing, or **publisher**. 
  - This can be done even if the modifiable set of objects is **unknown beforehand** or **changes dynamically**.

Advantage:
- Follows **Open-Closed** principle
 - Gives us the flexibility to **introduce new subscriber classes** without having to change the publisher's code, **and vice versa** if there's a publisher interface.

Key Terminologies:
- **Publisher** (Store): lets new subscribers **join** and current subscribers **leave**.
- **Subscriber** (Customer i.e. EventListener)
- **Concrete Subscriber** (EmailListener / MobileAppListener)
- **Client** (Main): Creates **publisher** and **subscriber** objects separately and **registers** the subscribers for publisher updates.

### Strategy

Real Life Scenario: Integrating a Payment Service into Restaurant App

Challenge: Application should be able to seamlessly integrate multiple payment options in the future.

- We need to place each payment method in its own class making this class responsible for a particular payment strategy.
- Additionally, these classes should be easily interchangeable by one another.

What?
- Defines a **family of algorithms**, puts each of them in a **separate class**, and makes their objects **interchangeable**.
- Applies the **Single Responsibility** and the **Open-Closed** Principle.

How?
- Each strategy is **isolated** in a separate class, and we can **easily introduce new strategies**.
- Strategies are easily **replaceable** and interchangeable by clients **at runtime**.

Key Terminologies:
- **Context** (PaymentService): maintains a reference to a concrete **strategy** and communicates with  it via the **interface**.
- **Strategy** (Interface)
- **Concrete strategy**

### State

Real Life Scenario: Phone Actions (Home button, Power button)

What?
- **Finite-State Machine**
 - At any given moment there's a **finite** number of **states** in which a program can be, and within any unique state the program **behaves differently**.
 - A state can **switch the state** of our program to another on or not switch it at all.
 - these switching rules, called **transitions**, are finite and predetermined.
- allows an object **alter** its **behavior** when its **internal state changes**.
- extracts each logic to a **separate class** and lets the **context delegate the behavior** to the corresponding state class.

How?
We need few things:
- **Context**: What is the object that changes states? (here Phone)

Key Terminologies:
- **Context** class (Phone class): that stores a reference to its **current** concrete **state** (initialized as the **initial** state) to start with. 
  - The context communicates with the state objects only via the State **interface** or the **abstract** class.
- **Interface** or **abstract** class (State): declares the **state-specific** methods.
- **Concrete States** (Off / Ready / Locked State): provide **their own implementations** for the state-specific methods.

### State vs Strategy

State can be considered as an extension of Strategy as both patterns are based on **composition**, they **change the behavior** of the context by **delegating** some work to helper objects.

| State                                                                                                 | Strategy                                                                                                      |
|-------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| States can be **dependent** as you can easily **jump from one** state **to another**.                 | Strategies are completely **independent** and **unaware** of each other.                                      |
| The  State pattern is about **doing different things based on the state**, hence the result may vary. | The Strategy pattern is really about having **different implementations** that **accomplish the same thing**. |

### Iterator

Suppose we have a graph data structure.
Now, we want to allow the users to travel the graph, but we also do not want to expose the underlying implementation of this graph.
Traversal of this graph could be either:
- Depth-First Search
- Breadth-First Search
- In-order traversal
- Pre-order traversal
- Post-order traversal

Now, the **Iterator** will traverse the graph according to the algorithm we picked regardless of the actual underlying implementation of this graph.

**What?**
- Extracts the **traversal behavior** of a collection into a separate object called an **iterator**.
- Traverses the elements of a collection **without exposing** its underlying representation.
- Encapsulates all the traversal details (such as the current position and how many elements are left till the end).

**Advantage:**
- Several iterators can go through the **same** collections at the same time **independently** of one another.
- Reduces traversal code **duplication**.
- Applies **Single Responsibility** and the **Open-Closed** principles. 
- Each iteration algorithm is **extracted in a separate class**, and **new iterators can be added** without modifying existing ones.

### Visitor

Real Life Scenario: Client's Insurance Company

So, we extract the common behavior to a Client class and extend it to all the concrete classes (Company, Restaurant, etc).
Now, lets we want to Add a Mailing functionality into the system.
So that, depending on the client:
- if Resident, then a medical insurance mail will be sent.
- if Bank, then a theft insurance mail will be sent.

Going straightforward, adding `abstract` method `sendMail()` to the `Client` class and then overriding for the respective classes is fine.
  
Problem:-
But, this **violates** **Open-Closed** principle and **Single-Responsibility** principle.
Each class has **actual functionality** that may break the code.
Each client's implementation is now **open to modification** and a single change delegates to all these classes.

Solution:-
We need something that allows us to **extract these behaviors** outside the client **classes** on which they **operate**.

**What?**
- Separates the **algorithms** or behaviors from the **objects on which they operate** and places them in a single class.
  
**Advantage**
- Classes will be more **focused** on their main job hence enforcing the **Single Responsibility Principle**.
- Applies the **Open-Closed Principle** as new **visiting behaviors** can be easily **introduced without modifying** existing ones.
- Visitors are **easily interchangeable** by clients at runtime.

#### Double Dispatch

Since, the objects know (only) their own classes, we will have to typecast (or use `instance of`) to correctly call the required methods.

What?
- **Delegates** choosing the proper method to the **object itself** instead of letting the client select a method.

**Advantage**:
- New visiting behaviors can now be easily introduced!

## Structural

### Adapter

Real Life Scenario: Zomato
Previously application built using XML as the data exchange format.
Now, in order to scale the application, modern frameworks use JSON as the data exchange format.

**What?**:
- Takes all of our XML data and transforms it to JSON making it **compatible** with the 3rd-party library we are making use of.

**How?**:
- Allows objects with **incompatible interfaces** to **collaborate** with one another.
- Uses both **inheritance** and **composition** principles by extending one of the objects and wrapping the second.
- **Translates client class** into something that the wrapped service can **understand**.
- Acts as a **middle-layer class** that server as a **translator**.

**Advantage**:
- Applies the **Single Responsibility** and the **Open-Closed** principles.
- Adapting behaviour is **separated** and we can introduce **new adpaters** without breaking  **existing** code.

### Bridge

Real Life Scenario: Pizza Delivery Business.

"The farther we go, the worse it gets".

Pizza -> Pepperoni Pizza and VeggiePizza

Our pizza business boomed and we found the need to have more pizzas.
Pizza ->
    - AmericanVeggiePizza
    - ItalianVeggiePizza
    - AmericanPepperoniPizza
    - ItalianPeeppperoniPizza

Adding new pizza types and the ways of preparing these pizzas to the hierarchy will grow exponentially.

This Problem occurs because we are trying to extend the pizza class in  **two independent dimensions**:
- The **type** of the pizza.
- The **way** we're preparing  the pizza.

**Solution**
- Bridge Design Pattern: Switch from **Inheritance** to **Composition**.
- Adding composition:
```java
public abstract class Restaurant  {
    
    // Pizza object is now added as an attribute (property)
    // to the newly created Restaurant class.
    // This will act as a bridge between the Pizza
    // and Restaurant classes.
    // With this approach, adding new pizza's will not require
    // to make any change in the Restaurant hierarchy and vice versa.
    protected Pizza pizza;
    
    // ...
}
```

**How?**
- Splits a large class (or a set of closely related classes) into two separate **hierarchies** (**abstraction** and **implementation**) which can be developed **independently** of each other.
- Client code **won't be exposed** to implementation details as it will only work with high-level abstraction.

**Advantage**:
- Giving flexibility to the user to get their own choice of pizza, from their own favorite restaurant.
- Applies the **Single Responsibility** and the **Open-Closed** Principles.
- **Independently introduce** new abstractions and implementations; making it very **easy to switch** between them **at runtime**.

```java
public class Main {
    public static void main(String[] args) {
        AmericanRestaurant americanRestaurant = new AmericanRestaurant(new PepperoniPizza());
        americanRestaurant.deliver();

        ItalianRestaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();
    }
}
```

**Key Components** (from Gang-of-4 book):
- **Abstraction** (Restaurant): 
 - provides high-level control logic
 - it **declares** behaviors that **rely** on operations declared by the implementation. 
- **Implementation** (Pizza): declares the interface common for all concrete implementations.
- **Client**: links the abstraction object with one of the implementation objects.

### Composite

Real Life Scenario: Amazon's Delivery System.

Each box can contain several other smaller boxes and products too. Each such box can further contain even smaller boxes or products.
Going for generic approach to find the total price for a single delivery can **VIOLATE** Single-Responsibility and Open-Closed principle.
For such a scenario, we have to know many details beforehand.

The solution to these problem resides in applying the Composite Design Pattern.

What?
- **Composes** objects into **tree structures** and then work with these structures as if they were individual structures.
- It only works when the model and object's structures of our application can be represented as a tree.

How?
- all elements share a *common interface* allowing the client to treat *individual objects* and *components uniformly*.

Advantage:
- We need not care about the concrete classes of objects that compose the tree.
- When we call a method, the objects themselves pass the requests down the tree.
- Applies the **OPEN-CLOSED** principle.
  - **Introduce new element types** into the application **without breaking** the existing code.

Key Components:
- **Component** Interface (`Box`)
  - describes **operations** that are common to both the **simple** and **complex** elements of the tree.
- **Composite** (`CompositeBox`)
  - has sub-elements but **doesn't know the concrete classes** of its children.
  - it works with all the sub-elements only via the Component interface.
- **Leaf** (`Book`/`Video Game`)
  - basic elements of the tree that **do not have** children
- **Client** works in the same way with both the complex and primitive objects of the tree via the **component interface**.

### Decorator

Real Life Scenario: Notification service of Online Food Delivery Application
- Delivery Departure/Arrival
- Delivery Discounts
- Receipt/Invoice etc.

Challenge:
- Having Inheritance based solution for this problem can turn out to be disaster. Example:
  - Suppose we have a Notifier Interface.
  - Now, We can have EmailNotifier to begin with
  - Later, we added WhatsAppNotifier and FacebookNotifier as well.
  - But, customer wants both WhatsApp and Facebook Notification at the same time.

Now, we cannot go and create WhatsAppAndFacebookNotifier to do this. This will exponentially increase the number of sub-classes.
- FacebookAndSMSNotifier
- WhatsAppAndSMSNotifier
- WhatsAppAndFacebookAndSMSNotifier

The solution to prevent this mess is by following the DECORATOR Design Pattern

**What?**
- Lets us attach new behaviors to an object by placing this object inside a **special wrapper** that contains these behaviors.
- Wrappers forces us to use **Composition** instead of **Inheritance**.

**How?**
- The advantage of **Composition** is that we can easily substitute our objects with one another because all of them belong to the same interface.
- This allows us to change the behavior of the container at runtime.
- An object can use the behavior of various classes; as it can reference multiple objects and can delegate them all kinds of work.

```java
import designpattern.structural.decorator.INotifier;

public abstract class BaseNotifierDecorator implements INotifier {
  private final INotifier wrapped;
  // ...
  
  @Override
  public void send(String message) {
      wrapped.send(message);
  }
}
```

- The rest of the code won't care whether we use the initial `Notifier` object or the decorated one.
- Since, all decorators implement the same interface `INotifier` as does the `BaseNotifier` class

```java
import designpattern.structural.decorator.FacebookDecorator;
import designpattern.structural.decorator.INotifier;
import designpattern.structural.decorator.WhatsAppDecorator;

public class Main {
  public static void main(String[] args) {
    INotifier notifier = new FacebookDecorator(
            // The Wrapped object provided to the Facebook decorator
            // is itself a WhatsApp decorated one
            new WhatsAppDecorator(
                // but the wrapped object provided to the WhatsApp decorator
                // is a simple Notifier object.
                new Notifier("username")
        )
    );
    notifier.send("message");
  }
}
```

**NOTE**:
- Debug `notifier.send()` and carefully observe the flow.

**Key Components**:
- Component `INotifer` (the Interface): declares the **common behaviors** for both **wrappers** and **wrapped** objects.
- Concrete Component `Notifier`
  - It's the wrapped class
  - It defines the **basic behavior**, which can be **altered** by **decorators**.
- Base Decorator `BaseNotifierDecorator` (abstract notifier):
  - **references** the **wrapped object** via the **interface**.
  - so that it can reference both the concrete component (`Notifier`) and its decorators (`FacebookDecorator`/`WhatsAppDecorator`).
- Concrete Decorators `FacebookDecorator`/`WhatsAppDecorator`
  - **override** the methods of the **base decorator**
  - but still **makes use of it** (using `super`).
- Client (`Main`):
  - **wraps components** in **layers of decorators**
  - but must **work via** the component **interface**.

**Summary**
- **Wraps** an existing object, allowing us to **add a new functionality** to that object **without altering its structure**.
  - assign **extra behaviors** to your object **at runtime** without breaking the code that uses that object.
- Applies the **Single Responsibility** and **Open-Closed** principles.
  - each behavior is **isolated** in a separate class, and
  - gives us the ability to **introduce new decorators without modifying** existing classes.

### Facade

Real Life Scenario: Buy/Sell Cryptocurrency App

Suppose we have used a third-party library `CryptoService` and of which we want to re-use the `buyCurrency()` method.
We can re-use it as follows such that required parameters of the method are available:

```java
public class Main {
    public static void main(String[] args) {
        CryptoFactory
                .getCryptoService("BTC")
                .buyCurrency(new User(), 1000);
    }
}
```

**Problems with this approach**:
- If this code was needed in other parts of our application, then the logic is open for **Duplication**.
- Again, what if we apply the same approach for other library tools like sending emails.

This makes our business logic **tightly coupled** to the implementation details of **the third-party classes**, and **hard to comprehend and maintain**.

**Solution**:
- We need a **centralized** place:
  - to put all the logic inside it, 
  - to center it, and 
  - to **restrict direct access** to the inner workings of the library.

**What**:
- Provides a **simplified interface** to a library, or a framework, or any other **complex** set of classes.

**How**:
- Class that serves as a **front-facing interface** that marks complex underlying **structural code**.
- Improves the **readability and usability** of a software library by **hiding the interaction** of its components.
- Applies the **Single-Responsibility** principle.
- Defines **entry points to each level of a subsystem**, thus decoupling multiple subsystems and **forcing them to communicate** only through facades.

**Key Components**:
- **Facade** `BuyCryptoFacade`: provides convenient access to a **particular point** of the subsystem's functionality.
  - Sometimes, the facade can grow **too big** and become a **God object**.
  - In that case, we may require additional facades that shall old related methods.
- **Subsystem Class** `CryptoFactory`/`CryptoDatabase`/`BitcoinService`
  - These classes aren't aware of the facade's existence,
  - they operate **within the system** and work with each other directly.
- **Client**: **Uses** the facade **instead of calling** the subsystem objects directly.

### Flyweight

Real Life Scenario: Revamp the Amazon UI Service section for Books.

**Problem**:
- Application crashes due to insufficient memory error
- Trying to create millions of copies of largely populated objects.

**What**?
- Lets us **fit more objects** into the available RAM by **sharing common parts of state between multiple objects, instead of storing all of the data in each object individually.
- Stop storing the **state that rarely changes** inside the object, but instead move it **into a separate object**.
- The state stored inside a flyweight is called **intrinsic**.

**How**?
- Find out properties common to the object (here `BOOK_TYPES`)
- Other related properties may also be common thereafter (here `distributor`, `otherData`)

#### Context `Book` (Extrinsic-Mutable)

- Contains the **extrinsic state** unique across all original objects.
- When a context is **paired with a flyweight** object, it represents the **full state** of the original object.

#### Flyweight class `BookType` (Intrinsic-Immutable)

```java
@Getter                 // immutability
@AllArgsConstructor     // all properties should exist
public class BookType {
  private final String type;
  private final String distributor;
  private final String otherData;
}
```
- stores the **intrinsic** state of the object which is:
  - **invariant context-independent**
  - **shareable** and 
  - **never altered** at runtime.
- is **immutable**.

#### Flyweight Factory `BookFactory`

- Returns the **flyweight possibilities** that we have.
- Usually consists of a `Map` to get the shared values of our flyweight
- **Manages** a pool of **existing flyweights**.

**NOTE**:
Flyweight Pattern is simply an **Optimization**, and before applying it, we need to make sure that our program **suffers from the RAM consumption problem** related to having a massive number of **similar objects in memory at the same time**.

### Proxy

- A proxy is an intermediary server that separates end-users with the websites that they browse.
- All the Request-Response in the network happens through this proxy.

But why do we even need it?
- Firewall (Restricting access to certain users)
- Filtering (Restricting access to a couple banned websites)
- Caching (Storing recently/frequently accessed resources for faster retrieval)
- Protection
- Privacy
- Security

Can we restrict the access from the Internet class itself:

```java
public class RealInternet implements Internet {
    @Override
    public void connectTo(String host) {
        if("banned.com".equals(host)) {
            System.out.println("Access Denied!");
            return;
        }
        System.out.println("Opened connection to " + host);
    }
}
```

This approach will turn the access down in the entire internet which we do not want.

**Solution**:
Introduce a Proxy Internet Server

**What**?
- Provides a **substitute** for another object and **controls access** to that object,
- allowing us to **perform something before or after** the request reaches the original object.
- Applies **Open-Closed Principle**, as we can **introduce new proxies** without changing the service not the clients.

**How?**:
- **implements the same interface** as the original object.

**Key Components**:
- ServiceInterface `Internet`/`VideoDownloader`
- Service `RealInternet`/`RealVideoDownloader`
- Proxy `ProxyInternet`/`ProxyVideoDownloader`
  - has a **reference** field that points to a service object.
  - after the proxy finishes the work it was intended to do,
    - **it passes the request to the service**.
- Client

