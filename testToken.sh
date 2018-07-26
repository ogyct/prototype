#!/usr/bin/env bash

url='localhost:8081'
token=`curl client:secret@"$url"/oauth/token -d grant_type=password -d username=admin.admin -d password=1990 | jq -r '.access_token'`
echo 'Bearer '"$token"
response=`curl http://"$url"/client/student/v1/getAllStudents -H "Authorization: Bearer "${token}""`
echo "$response"