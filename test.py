import requests
import sys
import json


def get_all_problems(tournament, sid):
    response = requests.get(f"https://imcs.dvfu.ru/cats/?f=problems;cid={tournament};sid={sid};json=1")
    a = response.json()
    problems = dict()
    for i in a['problems']:
        problems[i['id']] = i['name']
    return problems

def get_submits(tournament, sid):
    response = requests.get(f"https://imcs.dvfu.ru/cats/?f=console;cid={tournament};json=1;sid={sid}")
    a = response.json()
    submits = []
    for i in a:
        if i['type'] == 'submit':
            submits.append([i['id'], i['problem_id'], i['team_id'], i['state_text']])
    return submits


def get_users(tournament, sid):
    response = requests.get(f"https://imcs.dvfu.ru/cats/?f=users;cid={tournament};json=1;sid={sid}")
    a = response.json()
    users = dict()
    for i in a:
        users[i['account_id']] = i['name']
    return users


def get_all_info(tournament, sid):
    problems = get_all_problems(tournament, sid)
    subm = get_submits(tournament, sid)
    users = get_users(tournament, sid)
    all_info = []
    for i in range(len(subm)):
        a = dict()
        a["id_problem"] = subm[i][1]
        a["problem_name"] = problems[subm[i][1]]
        a["id_submit"] = subm[i][0]
        a["username"] = users[subm[i][2]]
        a["content_link"] = f"https://imcs.dvfu.ru/cats/?f=download_source;cid={tournament};rid={subm[i][0]};sid={sid}"
        a["current_status"] = subm[i][3]
        all_info.append(a)
    return all_info


sid = "kMH314lV3Yln4lN03DBiFMQhCcZxQx"
tournament = "5287221"

a = get_all_info(tournament, sid)
b = dict()
b["submit"] = a
print(json.dumps(b, indent=4, sort_keys=False))
