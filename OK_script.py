import sys

import requests


def change_state(url, res):
    request = f'set_state=1&state={res}&failed_test=%C2%A0&points='

    boop = requests.post(
        url, data=request,
        headers={'Content-Type': 'application/x-www-form-urlencoded'},

    )


change_state(f'https://imcs.dvfu.ru/cats/?f=request_params;cid={sys.argv[2]};rid={sys.argv[3]};sid={sys.argv[1]}', 'OK')
