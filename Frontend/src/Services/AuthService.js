async function LoginService(email,password) {
        const reponse = await fetch("http://localhost:8080/auth/login",{
            method:'POST',
            headers:{
                "Content-Type":"application/JSON"
            },
            body:JSON.stringify({email,password}),
            
            credentials:'include'
        });
        if(!reponse.ok){
            throw new Error("Login Failed")
        }

        return reponse.json();
    }
async function SignupService(fullName,email,password) {
        const reponse = await fetch("http://localhost:8080/auth/signup",{
            method:'POST',
            headers:{
                "Content-Type":"application/JSON"
            },
            body:JSON.stringify({fullName,email,password}),
            
            credentials:'include'
        });
        if(!reponse.ok){
            throw new Error("SignUp Failed")
        }

        return reponse.json();
    }
