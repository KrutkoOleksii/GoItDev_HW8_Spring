package ua.goit.hw8Spring.model;

@FunctionalInterface
public interface BaseEntity <ID>  {
    ID getId();
}
