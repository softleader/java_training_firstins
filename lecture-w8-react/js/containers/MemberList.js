import React from "react";
import {connect} from "react-redux";
import {getAll, add, update, remove} from "../actions/action";
import {MEMBER_EVENTS} from "../constants/Events";
import es6BindAll from "es6bindall";

class MemberList extends React.Component{

  constructor() {
    super();
    this.state = {
      members: [],
      entity: {empNo: "", name: ""},
      newEntity: {id: "", empNo: "", name: ""},
      showEdit: false
    };
    es6BindAll(this, ['handleChange', 'handleSubmit', 'toggleEdit', 'handleUpdate', 'handleEditChange', 'handleRemove']);
  }

  componentDidMount() {
    this.props.dispatch(getAll(MEMBER_EVENTS.GET_ALL, '/sample/member'));
  }

  componentWillReceiveProps(nextProps) {
    this.setState({members: nextProps.members});
  }

  handleChange(e) {
    this.setState({entity: {...this.state.entity, [e.target.name]: e.target.value}})
  }

  handleEditChange(e) {
    this.setState({newEntity: {...this.state.newEntity, [e.target.name]: e.target.value}})
  }

  handleSubmit() {
    this.props.dispatch(add(MEMBER_EVENTS.ADD, '/sample/member', this.state.entity));
  }

  toggleEdit(show, member = this.state.newEntity) {
    this.setState({newEntity: member, showEdit: show});
  }

  handleUpdate() {
    this.props.dispatch(update(MEMBER_EVENTS.UPDATE, '/sample/member', this.state.newEntity));
    this.toggleEdit(false);
  }

  handleRemove(member) {
    this.props.dispatch(remove(MEMBER_EVENTS.REMOVE, '/sample/member', member));
  }

  render() {
    const members = this.state.members.map(m => {
        return (
            this.state.showEdit && this.state.newEntity.id === m.id ?
              <tr key={m.id}>
                <td><input type="text" name="empNo" value={this.state.newEntity.empNo} onChange={this.handleEditChange} /></td>
                <td><input type="text" name="name" value={this.state.newEntity.name} onChange={this.handleEditChange} /></td>
                <td><input type="button" value="儲存" onClick={this.handleUpdate} /></td>
              </tr> :
              <tr key={m.id}>
                <td>{m.empNo}</td>
                <td>{m.name}</td>
                <td><input type="button" value="編輯" onClick={() => this.toggleEdit(true, m)} /></td>
                <td><input type="button" value="刪除" onClick={() => this.handleRemove(m)} /></td>
              </tr>
        );
      }
    );

    return(
      <>
        <table className="table">
          <thead>
            <tr>
              <th className="col-md-2">EMP_NO</th>
              <th className="col-md-2">NAME</th>
            </tr>
          </thead>
          <tbody>
            {members}
          </tbody>
        </table>
        <br/>
        EmpNo: <input type="text" name="empNo" value={this.state.entity.empNo} onChange={this.handleChange} />
        Name: <input type="text" name="name" value={this.state.entity.name} onChange={this.handleChange} /> <br/>
        <input type="button" defaultValue="新增" onClick={this.handleSubmit} />
      </>
    );
  }
}

const mapStatusToProps = (status) => {
  return {
    members: status.member.list
  }
};

export default connect(mapStatusToProps)(MemberList);