import requests
import sys

sid = 'z3XkbVpSEtMNKJoypMzR8R0STMtl72'

def get_all_problems():
    response = requests.get(f"https://imcs.dvfu.ru/cats/?f=problems;cid=5287221;sid={sid};json=1")
    a = response.json()
    problems = dict()
    for i in a['problems']:
        problems[i['id']] = i['name']
    return problems


def get_submits():
    response = requests.get(f"https://imcs.dvfu.ru/cats/?f=console;cid=5287221;sid={sid};json=1")
    a = response.json()
    submits = []
    for i in a:
        if i['type'] == 'submit':
            submits.append([i['id'], i['problem_id'], i['team_id'], i['state_text']])
    return submits


def get_users():
    response = requests.get(f"https://imcs.dvfu.ru/cats/?f=users;cid=5287221;sid={sid};json=1")
    a = response.json()
    users = dict()
    for i in a:
        users[i['account_id']]=i['name']
    return users


def run():
    problems = get_all_problems()
    subm = get_submits()
    users = get_users()
    all_info = []
    for i in range(len(subm)):
        a = dict()
        a["id_problem"] = subm[i][1]
        a["problem_name"] = problems[subm[i][1]]
        a["id_submit"] = subm[i][0]
        a["username"] = users[subm[i][2]]
        a["content_link"] = ""
        a["current_status"] = subm[i][3]
        all_info.append(a)
    return all_info

# Python program to demonstrate
# sys.argv


