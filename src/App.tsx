import { useState } from "react";
import axios from "axios";

function App() {
  const [userId, setUserId] = useState("");
  const [amount, setAmount] = useState(0);
  const [merchant, setMerchant] = useState("");
  const [result, setResult] = useState("");

  const submitTransaction = async () => {
    try {
      const response = await axios.post("http://localhost:8080/transactions", {
        userId,
        amount,
        merchant
      });
      setResult(response.data);
    } catch (err) {
      console.error(err);
      setResult("Error submitting transaction");
    }
  };

  return (
    <div className="p-10 max-w-md mx-auto">
      <h1 className="text-3xl font-bold mb-5">Sentinel-Flow</h1>

      <div className="flex flex-col gap-3">
        <input type="text" placeholder="User ID" value={userId} onChange={e => setUserId(e.target.value)} className="border p-2 rounded"/>
        <input type="number" placeholder="Amount" value={amount} onChange={e => setAmount(Number(e.target.value))} className="border p-2 rounded"/>
        <input type="text" placeholder="Merchant" value={merchant} onChange={e => setMerchant(e.target.value)} className="border p-2 rounded"/>
        <button onClick={submitTransaction} className="bg-blue-500 text-white p-2 rounded hover:bg-blue-600">Submit</button>
      </div>

      {result && <p className={`mt-5 text-xl font-semibold ${result === "FRAUD" ? "text-red-500" : "text-green-500"}`}>Result: {result}</p>}
    </div>
  );
}

export default App;