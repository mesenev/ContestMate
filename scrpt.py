import requests


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
        users[i['account_id']]=i['name']
    return users


def get_all_info(tournament, sid):
    problems = get_all_problems(tournament, sid)
    subm = get_submits(tournament, sid)
    users = get_users(tournament, sid)
    """all_info = {}
    for i in range(len(subm)):
        a = dict()
        a["id_problem"] = str(subm[i][1])
        a["problem_name"] = str(problems[subm[i][1]])
        a["id_submit"] = str(subm[i][0])
        a["username"] = str(users[subm[i][2]])
        a["content_link"] = f"https://imcs.dvfu.ru/cats/?f=download_source;cid={tournament};rid={subm[i][0]};sid={sid}"
        a["current_status"] = str(subm[i][3])
        all_info[f"user{i}"] = a"""
    all_info = []
    for i in range(len(subm)):
        all_info.append(str(subm[i][1]) + " \n")
        all_info.append(str(problems[subm[i][1]]) + " \n")
        all_info.append(str(subm[i][0]) + " \n")
        all_info.append(str(users[subm[i][2]]) + " \n")
        all_info.append(f"https://imcs.dvfu.ru/cats/?f=download_source;cid={tournament};rid={subm[i][0]};sid={sid}" + " \n")
        all_info.append(str(subm[i][3]) + " \n")
    file1 = open("myfile.txt", "w")

    file1.writelines(all_info)
    file1.close()
    return all_info


sid = "z3XkbVpSEtMNKJoypMzR8R0STMtl72"
tournament = "5287221"
# f = open('resu.txt', "w")
# f.write(get_all_info(tournament, sid))
print(get_all_info(tournament, sid))