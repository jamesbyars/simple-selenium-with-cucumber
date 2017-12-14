# Simple Selenium Tests Using Cucumber

This example project demonstrates how one could simplify 
functional testing and enhance business => developer 
communication by combining the [Selenium](http://www.seleniumhq.org/) 
Web Testing Framework with [Cucumber.io](https://cucumber.io/).

# How does it work?

This project uses [Cucumber.io](https://cucumber.io/) to define scenarios 
that are then carried out by [Selenium](http://www.seleniumhq.org/).  Add 
your feature files to the features directory in 'src/test/resources'.  Next,
Run `mvn test`.  That's it.

# How do I write feature files

Imagine you are developing a system to keep score of a bowling game.  You 
would define your behavior similar to the following:

```gherkin
Given I have a new frame
When I knock down all the pins
Then I score a strike
```

We call this a Scenario.  The scenario has a precondition - the 'Given', 
an action - the 'When', and a test - the 'Then'.  For our test to pass 
our system must score a strike when all the pins are knocked down in a 
new frame.

# I want to know more about the technology used

## Cucumber

Cucumber is a framework for [Behavior Driven Development](https://en.wikipedia.org/wiki/Behavior-driven_development)
, or BDD.  BDD is a method for developing software in which you define 
the behavior you want the software to perform as tests.  

BDD uses a language called [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) 
to describe the behavior.  Gherkin's purpose is to be an simple, business 
readable language.  In this example, we will use Gherkin to describe the 
behavior of webpages under test. 

If you want to know more about Cucumber, visit [Cucumber.io](https://cucumber.io/).

## Selenium

[Selenium](http://www.seleniumhq.org/)  is a tool for automating web browser testing.  It provides a simple 
API to perform everything a human could do when navigating a web site.  
 




