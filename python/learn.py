# variables
developer = 'Devin'

# print function
print(type(developer))

# datatypes and type objects
my_integer_var = 10
print(type(my_integer_var))  # <class 'int'>

my_float_var = 4.50
print(type(my_float_var))  # <class 'float'>

my_string_var = 'hello'
print(type(my_string_var))  # <class 'str'>

my_boolean_var = True
print(type(my_boolean_var))  # <class 'bool'>

my_set_var = {7, 'hello', 8.5}
print(type(my_set_var))  # <class 'set'>

my_dictionary_var = {'name': 'Alice', 'age': 25}
print(type(my_dictionary_var))  # <class 'dict'>

my_tuple_var = (7, 'hello', 8.5)
print(type(my_tuple_var))  # <class 'tuple'>

my_range_var = range(5)
print(type(my_range_var))  # <class 'range'>

my_list = [22, 'Hello world', 3.14, True]
print(type(my_list)) # <class 'list'>

my_none_var = None
print(type(my_none_var))  # <class 'NoneType'>

account_balance = '12'

isinstance(account_balance, int) # False
isinstance(account_balance, (int, float))

name = 'Alice'
print(name, type(name))

is_student = True
print(is_student, type(is_student))

age = 20
print(age, type(age))

score = 80.5
print(isinstance(score, float))
print(score,type(score))

#Strings
first_name = 'John'
last_name = 'Doe'
full_name = first_name + ' ' + last_name
address = '123 Main Street'
address += ', Apartment 4B'
employee_age = 28
employee_info = full_name + ' is ' + str(employee_age) + ' years old'
print(employee_info)
experience_years = 5
experience_info = 'Experience: ' + str(experience_years) + ' years'
print(experience_info)
position = 'Data Analyst'
salary = 75000
employee_card = f'Employee: {full_name} | Age: {employee_age} | Position: {position} | Salary: ${salary}'
print(employee_card)
employee_code = 'DEV-2026-JD-001'
department = employee_code[0:3]
print(department)
year_code = employee_code[4:8]
print(year_code)
initials = employee_code[9:11]
print(initials)
last_three = employee_code[-3:]
print(last_three)

my_str = 'hello world'
uppercase_my_str = my_str.upper()
lowercase_my_str = my_str.lower()
trimmed_my_str = my_str.strip()
replaced_my_str = my_str.replace('hello', 'hi')
split_words = my_str.split()
my_list = ['hello', 'world']
joined_my_str = ' '.join(my_list)
starts_with_hello = my_str.startswith('hello')
ends_with_world = my_str.endswith('world')
world_index = my_str.find('world')
o_count = my_str.count('o')
capitalized_my_str = my_str.capitalize()
is_all_upper = my_str.isupper()
is_all_lower = my_str.islower()
title_case_my_str = my_str.title()


# Numbers and Operations
# operations +,-,/,*,%,//,**,
# float() function, int() function, round(), abs(), pow()
# assignment operators +=, -=, *=. /=, //=, %=, **=, 
greet = 'Hello'
greet += ' World'
greet *= 3
my_var = 5
my_var += 1 #increment
my_var -= 1 #decrement
