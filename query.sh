#!/bin/bash

border="------------------------------------------------------"
attributes=("Diversified" "Growth-Oriented")

echo -e "\n"

echo "$border"
echo "| \"Risk Appetite\": [ \"${attributes[0]}\", \"${attributes[1]}\" ] |"
echo "$border"

echo -e "\n"

echo -e "\n      -------- RESPONSE ----------- " && curl -s -X POST -H "Content-Type: application/json" -d '{
"attributes": ["'"${attributes[0]}"'","'"${attributes[1]}"'"]
}' http://localhost:8080/portfolio/advice | jq . && echo -e "\n     -------- RESPONSE ----------- "
