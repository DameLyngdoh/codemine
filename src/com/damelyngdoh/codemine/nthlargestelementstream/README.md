# Nth Largest Element Using Streams

Given a list of elements, find the second n<sup>th</sup> element (certain comparing criteria provided) in the list using Streams.

In the example, an employee class contains the members `id`, `salary` and `name` which should be self-explanatory. The stream manipulation should find the employee with the n<sup>th</sup> (in the code, the example is second) largest salary. To understand how the elements (employees) are sorted based on salary, the `Comparator` (`java.util.Comparator`) interface is implemented (lambda function style). The `skip` function is what will determine how many elements to skip or ignore before finally using the `findFirst` to take the element immediately availabe after the ignored elements.

Note: For comparing, the class `Employee` can implement `Comparable` and then implement the `compareTo` method. One reason why `Comparator` is preferred is because the comparison strategy or implementation can be decoupled from the class and can be maintained seperately.
