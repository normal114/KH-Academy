name = "Kildong" # 이름
dept = "IT"      # 부서

# str concatenation
print("I am " + name + ". I belong to " + dept + " department.")

# %-formatting
print("I am %s. I belong to %s department." % (name, dept))

# str.format()
print("I am {}. I belong to {} department.".format(name, dept))

# f-strings (Python 3.6부터 지원)
print(f"I am {name}. I belong to {dept} department.")