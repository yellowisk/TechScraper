from selenium import webdriver

browser = webdriver.Chrome()

choice = input('please, choose a roadmap: ')

print('you just chose the ' + choice + ' roadmap')

browser.get('https://roadmap.sh/'+choice)

while(True):
    pass