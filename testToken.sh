#!/usr/bin/env bash

url='localhost:8081'
token=`curl -s client:secret@"$url"/oauth/token -d grant_type=password -d username=admin.admin -d password=1990 | jq -r '.access_token'`
echo "Token "
echo 'Bearer '"$token"
response=`curl -s http://"$url"/client/student/v1/getAllStudents -H "Authorization: Bearer "${token}""`
echo "WS response:"
echo "$response"
echo "Token validity:"
curl -s -X GET --header "Accept: application/json" "http://localhost:8081/oauth/check_token?token="$token""
