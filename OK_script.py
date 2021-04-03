import sys

import requests


def click_button(url, res):
    request = f'set_state=1&state={res}&failed_test=%C2%A0&points='

    boop = requests.post(
        url, data=request,
        headers={'Content-Type': 'application/x-www-form-urlencoded'},

    )


sid = "XWq3nAzNeTnOW2y7wXy2VNACuK0cZF"
tournament = "5287221"
click_button(f'https://imcs.dvfu.ru/cats/?f=request_params;cid={tournament};rid={sys.argv[1]};sid={sid}', 'OK')
print("1")
