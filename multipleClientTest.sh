java SorterClient testClient1.txt > expectedOutput_Client1.txt &process_id=$!
java SorterClient testClient2.txt > expectedOutput_Client2.txt &process_id=$!
java SorterClient testClient3.txt > expectedOutput_Client3.txt &process_id=$!
java SorterClient testClient4.txt > expectedOutput_Client4.txt &process_id=$!

wait $var_id_1
echo "Client 1 Test finish"
wait $var_id_2
echo "Client 2 Test finish"
wait $var_id_3
echo "Client 3 Test finish"
wait $var_id_4
echo "Client 4 Test finish"

echo "All Client Test finish"

echo
echo
echo "Client 1 output"
cat expectedOutput_Client1.txt

echo
echo
echo "Client 2 output"
cat expectedOutput_Client2.txt


echo
echo
echo "Client 3 output"
cat expectedOutput_Client3.txt


echo
echo
echo "Client 4 output"
cat expectedOutput_Client4.txt