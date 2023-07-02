package designpattern.behavioral.mediator.with;

// Components have a reference to the interface of the
// mediator allowing us to reuse this component
// in other programs.
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
