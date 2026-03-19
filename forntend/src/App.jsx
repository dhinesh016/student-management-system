import { useEffect, useState } from "react";
import axios from "axios";
import "./style.css"
const App = () => {
  const [students, setStudents] = useState([]);
  const [filterdata,setfitereddata]=useState([]);
  const [search,setSearch]=useState("");
  const [student, setStudent] = useState({
    name: "",
    email: "",
    dept: "",
    dob: "",
  });
  const[loading,setLoading]=useState(true);
  const API="http://localhost:9091/students"
  useEffect(() => {
    getStudents();
  }, []);
  const getStudents = async () => {
    const students = await axios.get(API);
    console.log(students.data);
    setStudents(students.data);
    setfitereddata(students.data)
    setLoading(false)
   
  };
    {/*setInterval(()=>(
      setLoading(false)
    ),1000)*/}
  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
    console.log(student);
  };
  const handleSubmit = async(e) => {
    e.preventDefault();
    setLoading(true);

    if(student.id){
        await axios.put(`${API}/${student.id}`,student)
    }
    else{
        await axios.post(API,student)
    }
    setStudent({
      name: "",
      email: "",
      dept: "",
      dob: "",
    });
    getStudents();
    setLoading(false)
    console.log(student);
  };
  const handleEdit=(student)=>{
       setStudent(student);
  }
  const handleDelete=async(id)=>{
    if(confirm("Are sure to Delete...")){
      await axios.delete(`${API}/${id}`)
       getStudents();
    }
    else{
      getStudents();
    }
     
    
  }
  const handleSearch=(value)=>{
     setSearch(value);
     const filterdata=students.filter((s)=>
        s.id.toString().includes(value)||s.name.toLowerCase().includes(value.toLowerCase())||s.email.includes(value)
     )
     setfitereddata(filterdata);
  }
  return (
   <div className="main-continer">
      <div className={loading?"loading display":"loading"}><div class="loader"></div></div>
      <form className="form-continer" onSubmit={handleSubmit}>
         <div className="head">
          <h1>Student Management System</h1>
           <h3>Enter Student Details</h3>
        </div>
        <div className="data">
        <label htmlFor="name">Enter your name</label>
        <input
          type="text"
          placeholder="Enter your name"
          name="name"
          onChange={handleChange}
          value={student.name}
          required

        />
        </div>
        <div className="data">
        <label htmlFor="name">Enter your email</label>
        <input
          type="email"
          placeholder="Enter your email"
          name="email"
          onChange={handleChange}
          value={student.email}
          required

        />
        </div>
       
       <div className="data">
         <label htmlFor="name">Enter your dept</label>
        <input
          type="text"
          placeholder="enter your dept"
          name="dept"
          onChange={handleChange}
          value={student.dept}
          required

        />
       </div>
        <div className="data">
        <label htmlFor="name">Enter your DoB</label>
        <input
          type="date"
          placeholder="enter your dob"
          name="dob"
          onChange={handleChange}
          value={student.dob}
          required
        />
        </div>
      <div className="search">
          <input type="search" placeholder="Search by ID/Name,Email...." value={search} onChange={(e)=>handleSearch(e.target.value)
        }/>
        <button type="submit" className="green">{student.id?"update":"add"}</button>
      </div>
      </form>
      <table className="table-continer">
        <thead>
          <tr>
            <th>S.No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>DateofBirth</th>
            <th>Edit</th>
            <th>delete</th>
          </tr>
        </thead>
        <tbody>
          {filterdata.length>0?filterdata.map((data, index) => (
            <tr key={data.id}>
              <td>{index + 1}</td>
              <td>{data.id}</td>
              <td>{data.name}</td>
              <td>{data.email}</td>
              <td>{data.dept}</td>
              <td>{data.dob}</td>
              <td>
                <button className="green" onClick={()=>handleEdit(data)}>Edit</button>
              </td>
              <td>
                <button onClick={()=>handleDelete(data.id)}>Delete</button>
              </td>
            </tr>
          )):<tr className="empty"><td colSpan={8}>No recodes Found....</td></tr>}
        </tbody>
      </table>
    </div>
  );
};

export default App;
