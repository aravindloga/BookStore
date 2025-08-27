async function getAllBooksService() {

    const reponse = await fetch("http://localhost:8080/public/getAll",{
        method:'GET',
        credentials:'include'
    })

    if(!reponse.ok){
        throw new Error("Failed to fetch")
    }
    
    return reponse.json()
}
async function getAllCartService() {

    const reponse = await fetch("http://localhost:8080/public/getCart",{
        method:'GET',
        credentials:'include'
    })

    if(!reponse.ok){
        throw new Error("Failed to fetch")
    }
    
    return reponse.json()
}
async function getAllBooksByCategoryService(catgory) {

    const reponse = await fetch(`http://localhost:8080/public/getByCatgory?catgory=${catgory}`,{
        method:'GET',
        credentials:'include'
    })

    if(!reponse.ok){
        throw new Error("Failed to fetch")
    }
    
    return reponse.json()
}
async function DeleteBooksService(id) {

    const reponse = await fetch(`http://localhost:8080/admin/deletebooks?id=${id}`,{
        method:'DELETE',
        credentials:'include'
    })

    if(!reponse.ok){
        throw new Error("Failed to delete")
    }
    
    return reponse.json()
}
async function AddBooksService(bookData) {

    const reponse = await fetch("http://localhost:8080/admin/save",{
        method:'POST',
        headers:{
            "Content-Type": "application/json"
        },
        credentials:'include',
        body:JSON.stringify(bookData)
    })

    if(!reponse.ok){
        throw new Error("Failed to add")
    }
    
    return reponse.json()
}
async function UpdateService(bookData) {

    const reponse = await fetch("http://localhost:8080/admin/update",{
        method:'PUT',
                headers:{
            "Content-Type": "application/json"
        },
        credentials:'include',
        body:JSON.stringify(bookData)
    })

    if(!reponse.ok){
        throw new Error("Failed to Update")
    }
    
    return reponse.json()
}
