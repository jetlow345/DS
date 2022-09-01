java SorterClient testClient1.txt > expectedOutput_OneClient.txt
if diff expectedOutput_OneClientTest.txt; then
    echo "One Client Test Failed"; 
    else 
    echo "One Client Test Passed";
fi



