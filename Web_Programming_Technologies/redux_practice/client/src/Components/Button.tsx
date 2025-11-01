interface ButtonProps{
    children : string,
    onClick : ()=> void,
    cn : string
}

export default function Button(props :  ButtonProps){
    const {children, onClick, cn} = props;
    return <button className={cn}  onClick={onClick}>{children}</button>
}